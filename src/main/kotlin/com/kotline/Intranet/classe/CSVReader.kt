package com.kotline.Intranet.classe

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.lang.NumberFormatException
import java.nio.file.Paths
import java.nio.file.Files
import java.time.LocalDate
import java.time.Period;

class CSVReader {
    fun CSVReader(): Unit {
        val CSV_File_Path = "french-data.csv"
        // read the file
        val reader = Files.newBufferedReader(Paths.get(CSV_File_Path))
        // parse the file into csv values
        val csvParser = CSVParser(reader, CSVFormat.DEFAULT)
        for (csvRecord in csvParser) {
            // Accessing Values by Column Index
            val id = csvRecord.get(0)
            val gender = csvRecord.get(1)
            val titre = csvRecord.get(3)
            val name = csvRecord.get(4)
            val lastName = csvRecord.get(6)
            val street = csvRecord.get(7)
            val city = csvRecord.get(8)
            val zipCode = csvRecord.get(11)
            val country = csvRecord.get(13)
            val email = csvRecord.get(14)
            val tel = csvRecord.get(18)
            val poids = csvRecord.get(38)
            val taille = csvRecord.get(40)
            val latitude = csvRecord.get(41)
            val longitude = csvRecord.get(42)
            val dateNaissance = csvRecord.get(21)

            //print the value to console
            println("---------------")
            println("ID: $id $titre$name $lastName")
            println("Adresse mail: $email")
            println("Tel: $tel")
            println("Date Naissance: $dateNaissance")

            try {
                val daten = dateNaissance.split('/').toTypedArray()
                val moisNaissance = daten[0].toInt()
                val jourNaissance = daten[1].toInt()
                val anneeNaissance = daten[2].toInt()
                val age = getAge(jourNaissance, moisNaissance, anneeNaissance)
                println("Âge : $age")
            } catch (e: NumberFormatException) {
                //c'est la ligne 1 c'est la rue
            }
            println("Adresse: $street, $city $zipCode, $country")
            println("Taille: $taille cm")
            println("Poids: $poids kg")
            println("Coordonées GPS: $latitude , $longitude")
            println("---------------")
        }
    }


    fun getAge(jour: Int, mois: Int, annee: Int): Int {
        return Period.between(
            LocalDate.of(annee, mois, jour), LocalDate.now()
        ).years
    }
}