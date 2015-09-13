package bookmybook

import grails.converters.JSON

class BookController {

    def index() { }

    def getMyBooks() {
        def returnMap = [:]
        returnMap.status = "FAILURE"

        def deviceId = params.DEVICE_ID

        def books = User.createCriteria().list{
            projections("books")
            "eq"('deviceId', deviceId)
        }

        returnMap = [status: "SUCCESS", books: books]
        render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
    }

    def findBooks() {
        def returnMap = [:]
        returnMap.status = "FAILURE"

        def author = params.AUTHOR
        def name = params.NAME
        def city = params.CITY

        if(!city || (!author && !name)) {
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        }

        authorLike = "%" + author + "%"
        nameLike = "%" + name + "%"

        def users = User.createCriteria().list{
            'books' {
                'like'('name', nameLike)
                'like'('author', authorLike)
            }
            'eq'('city', city)
        }

        def userBookList = users.collect{
            def books = it.books
            def relevantBooks = books.findAll{it.name.contains(name) && it.author.contains(author)}
            new Expando(userName: it.name, userEmail: it.email, books: relevantBooks)
        }

        returnMap = [userBookList: userBookList, status: "SUCCESS"]
        render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
    }

    def saveBook() {
        def returnMap = [:]
        returnMap.status = "FAILURE"

        def author = params.AUTHOR
        def name = params.NAME

        if(!author || !name) {
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        }

        def book = Book.findByNameAndAuthor(name, author)

        if(book) {
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        } else {
            new Book(name: name, author: author).save(flush: true, failOnError: true)
        }

        returnMap.status = "SUCCESS"
        render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
    }
}
