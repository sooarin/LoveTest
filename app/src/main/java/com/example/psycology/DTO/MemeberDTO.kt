package com.example.psycology

class MemberDTO {

    var id:String
    lateinit var passwd:String
    var name:String
    var phonenumber:String
    var address:String
    // 암호 없이 멤버정보를 가져올때
    constructor(id:String, name:String, phonenumber:String, address:String) {
        this.id = id
        this.name = name
        this.phonenumber = phonenumber
        this.address = address
    }
    // 데이터베이스에 멤버정보를 추가할때
    constructor(id:String, passwd:String, name:String, phonenumber:String, address:String) {
        this.id = id
        this.passwd = passwd
        this.name = name
        this.phonenumber = phonenumber
        this.address = address
    }
}