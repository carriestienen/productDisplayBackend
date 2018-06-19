package productDisplayBackend

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

fun main(args: Array<String>) {

    var productsFileReader: BufferedReader? = null
    var partsFileReader: BufferedReader? = null

    try {
        val products = ArrayList<Product>()
        var line: String?

        // Read products.csv
        productsFileReader = BufferedReader(FileReader("csv_files/products.csv"))

        // Read header
        productsFileReader.readLine()

        // Read line by line
        line = productsFileReader.readLine()
        while (line != null) {
            val tokens = line.split(",")
            if (tokens.size > 0) {
                val product = Product(
                        tokens[0],
                        tokens[1],
                        tokens[2])
                products.add(product)
            }

            line = productsFileReader.readLine()
        }

        val parts = ArrayList<Product>()

        // Read parts.csv
        partsFileReader = BufferedReader(FileReader("csv_files/parts.csv"))

        // Read header
        partsFileReader.readLine()

        // Read line by line
        line = partsFileReader.readLine()
        while (line != null) {
            val tokens = line.split(",")
            if (tokens.size > 0) {
                val part = Part(
                        tokens[0],
                        tokens[1],
                        tokens[2],
                        tokens[3],
                        tokens[4],
                        Float.parseFloat(tokens[5]))
                parts.add(part)
            }

            line = partsFileReader.readLine()
        }

    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    } finally {
        try {
            partsFileReader!!.close()
            productsFileReader!!.close()
        } catch (e: IOException) {
            println("Closing fileReader Error!")
            e.printStackTrace()
        }
    }

    val url = "localhost:4200"
    val obj = URL(url)

    with(obj.openConnection() as HttpURLConnection) {

        BufferedReader(InputStreamReader(inputStream)).use {
            val response = StringBuffer()

            var inputLine = it.readLine()
            while (inputLine != null) {
                response.append(inputLine)
                inputLine = it.readLine()
            }
            println(response.toString())
        }
    }

}