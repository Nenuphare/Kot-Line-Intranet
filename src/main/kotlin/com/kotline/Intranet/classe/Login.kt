package com.kotline.Intranet.classe

class Login(
    val userName: String,
    val droit: String,
    val motDePasse: String)
{
    fun isMDPMatching(motDePasse: String){
        //TODO Faire matcher les mdp avec celui dans base de donnée
    }


    fun modifierUser(){
        //TODO faire en sorte que les compte admins et modos puissent changer les infos des clients
    }

    fun creerUser(){
        //TODO faire en sorte que compte modo et admin puisse creer des utilisateurs dans BDD
    }
}