package bookmybook

import grails.converters.JSON

class UserController {

    def index() { }

    def saveUser() {
        def returnMap = [:]
        returnMap.status="FAILURE"

        def deviceId = params.DEVICE_ID
        def name = params.NAME
        def email = params.EMAIL
        def city = params.CITY

        if (!deviceId || !emnail) {
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        }

        if(User.findByDeviceId(deviceId)) {
            returnMap.reason = "DeviceId Registered"
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        } else if(User.findByEmail(email)) {
            returnMap.reason = "Email Registered"
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        } else {
            new User(name: name, email: email, deviceId: deviceId, city: city).save(flush:true, failOnError: true)
        }

        returnMap.status="SUCCESS"
        render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
    }

    def findUser() {
        def returnMap = [:]
        returnMap.status="FAILURE"

        def deviceId = params.DEVICE_ID
        def name = params.NAME
        def email = params.EMAIL
        def city = params.CITY

        if (!deviceId || !emnail) {
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        }

        if(User.findByDeviceId(deviceId)) {
            returnMap.reason = "DeviceId Registered"
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        } else if(User.findByEmail(email)) {
            returnMap.reason = "Email Registered"
            render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
            return
        } else {
            new User(name: name, email: email, deviceId: deviceId, city: city).save(flush:true, failOnError: true)
        }

        returnMap.status="SUCCESS"
        render(text: returnMap as JSON, contentType: "application/json", encoding: "UTF-8");
    }
}
