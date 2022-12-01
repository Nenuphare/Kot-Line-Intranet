package com.kotline.Intranet.classe

class Bancaire(
    val CCType: String,
    val CCNum: Int,
    val CVV2: Int,
    val CCExpire: String): Client() {
}