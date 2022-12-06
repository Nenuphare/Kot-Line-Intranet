package com.kotline.Intranet.classe

class Login(
    val userName: String,
    val droit: String,
    val motDePasse: String)
{
    fun isMDPMatching(motDePasse: String): Boolean{
        return this.motDePasse == motDePasse
    }


    fun modifierUser(){
        //TODO faire en sorte que les compte admins et modos puissent changer les infos des clients


    }

    fun creerUser(){
        //TODO faire en sorte que compte modo et admin puisse creer des utilisateurs dans BDD
    }
}