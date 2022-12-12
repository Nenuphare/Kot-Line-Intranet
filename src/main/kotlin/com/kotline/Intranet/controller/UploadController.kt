package com.kotline.Intranet

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

@Controller
class UploadController {
    @GetMapping("/import")
    fun index(): String {
        return "templates/upload"
    }

    @PostMapping("/upload") // //new annotation since 4.3
    fun singleFileUpload(
        @RequestParam("file") file: MultipartFile,
        redirectAttributes: RedirectAttributes
    ): String {
        if (file.isEmpty) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload")
            return "redirect:uploadStatus"
        }
        try {

            // Get the file and save it somewhere
            val bytes = file.bytes
            val path = Paths.get(UPLOADED_FOLDER + file.originalFilename)
            Files.write(path, bytes)
            redirectAttributes.addFlashAttribute(
                "message",
                "You successfully uploaded '" + file.originalFilename + "'"
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return "redirect:/uploadStatus"
    }

    @GetMapping("/uploadStatus")
    fun uploadStatus(): String {
        return "templates/uploadStatus"
    }

    companion object {
        //Save the uploaded file to this folder
        private const val UPLOADED_FOLDER = "D:\\2emeAnnée\\Projet1"
    }
}