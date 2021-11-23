package com.example.testingfragmentwithlistview

import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.URL


class second : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val second = arrayOf<String>("Do something", "Do something", "Do something else")
        val listViewVar = view.findViewById<ListView>(R.id.listView1)
       val listViewAdapter = ArrayAdapter<String>(
           requireActivity(), android.R.layout.simple_list_item_1,
           CallTask().execute().toString().split(" ").map { it })

        listViewVar?.setAdapter(listViewAdapter)
        return view
    }



    // parsing json - start
    private inner class CallTask(): AsyncTask<Any, Void, String>(){

        private lateinit var customProgressDialog: Dialog
        override fun onPreExecute() {
            super.onPreExecute()

            //showProgressDialog()

        }

        override fun doInBackground(vararg params: Any?): String {
            var result: String

            var connection: HttpURLConnection? = null

            try{
                val url = URL("https://t0in4.github.io/testingjson.github.io/json_file.json") // using pastebin.net
                connection = url.openConnection() as HttpURLConnection
                connection.doInput = true
                connection.doOutput = true
                val httpResult: Int = connection.responseCode
                Log.i("http result: ", "$httpResult")

                if (httpResult == HttpURLConnection.HTTP_OK) {
                    val inputStream = connection.inputStream
                    val reader = BufferedReader(InputStreamReader(inputStream))
                    val stringBuilder = StringBuilder()
                    var line: String?
                    try {
                        while(reader.readLine().also {line = it} != null){
                            stringBuilder.append(line+"\n")
                        }
                    } catch(e: IOException){
                        e.printStackTrace()
                    } finally {
                        try{
                            inputStream.close()
                        }catch(e: IOException) {
                            e.printStackTrace()
                        }
                    }
                    result = stringBuilder.toString()
                }
                else {
                    result = connection.responseMessage
                }
            }catch (e: SocketTimeoutException) {
                result  = "Connection Timeout"
            } catch (e:Exception) {
                result = "Error :" + e.message
            }finally {
                connection?.disconnect()
            }

            return result




        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            //cancelProgressDialog()
            Log.i("JSON RESPONSE RESULT", result.toString()) // printing whole json in logcat
            /*val jsonObject = JSONObject(result)
            val data = jsonObject.optJSONArray("data")
            val need = mutableListOf<String>()
            // below we initializing intent
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            var first: String = "" //marketing
            var second: String = "" // and so on
            var third: String = ""
            var fourth: String = ""
            var fifth: String = ""
            var sixth: String = "" //mba
            for (i in 0 until data.length()) {

                need.clear() //clearing list of strings for the purpose of using it like an eax register
                var ourObject: JSONObject = data[i] as JSONObject
                val groups = ourObject.getJSONArray("groups")
                val direction = ourObject.getJSONObject("direction")
                val directionTitle = direction.optString("title")
                println(directionTitle)
                for (z in 0 until groups.length()) {
                    // testing json loading by printing every single step
                    //println("working")
                    val itemsObject: JSONObject = groups[z] as JSONObject
                    //println("working")
                    val items = itemsObject.getJSONArray("items")
                    //println("working")
                    for (x in 0 until items.length()) {
                        //println("working")
                        //println(items[x])

                        val titleObject: JSONObject = items[x] as JSONObject

                        val titleString = titleObject.optString("title")
                        //println(titleString)
                        need.add(titleString)

                    }

                }


                when(directionTitle) {
                    "Маркетинг" -> {
                        intent.putExtra(Constants.MARKETING, need.size.toString())
                        first = intent.getStringExtra(Constants.MARKETING).toString()
                    }
                    // in below variant we can use only one variable use_name without above in
                    // out of for scope 6 variables (first, second, third and so on)
                    // but every time we need to initialize intent
                    // in some cases (testing) this one is handy bcz outlook is equal
                    *//*{
                        val intent = Intent(this@MainActivity, MainActivity::class.java)
                        intent.putExtra(Constants.MARKETING, need.size.toString())
                        val use_name = intent.getStringExtra(Constants.MARKETING)
                        marketing.text = use_name
                        startActivity(intent)
                        finish()

                    }*//*
                    "Бизнес и управление" ->  {
                        intent.putExtra(Constants.BUSINESS, need.size.toString())
                        second = intent.getStringExtra(Constants.BUSINESS).toString()
                    }
                    *//*{
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    intent.putExtra(Constants.BUSINESS, need.size.toString())
                    val use_name = intent.getStringExtra(Constants.BUSINESS)
                    business.text = use_name
                    startActivity(intent)
                    finish()
                }*//*
                    "Программирование" -> {
                        intent.putExtra(Constants.CODING, need.size.toString())
                        third = intent.getStringExtra(Constants.CODING).toString()
                    }
                    *//*{
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    intent.putExtra(Constants.CODING, need.size.toString())
                    val use_name = intent.getStringExtra(Constants.CODING)
                    coding.text = use_name
                    startActivity(intent)
                    finish()
                }*//*
                    "Дизайн и UX" -> {
                        intent.putExtra(Constants.DESIGN, need.size.toString())
                        fourth = intent.getStringExtra(Constants.DESIGN).toString()
                    }
                    *//*{
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    intent.putExtra(Constants.DESIGN, need.size.toString())
                    val use_name = intent.getStringExtra(Constants.DESIGN)
                    design.text = use_name
                    startActivity(intent)
                    finish()
                }*//*
                    "Аналитика" -> {
                        intent.putExtra(Constants.ANALYTIC, need.size.toString())
                        fifth = intent.getStringExtra(Constants.ANALYTIC).toString()
                    }
                    *//*{
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    intent.putExtra(Constants.ANALYTIC, need.size.toString())
                    val use_name = intent.getStringExtra(Constants.ANALYTIC)
                    analytic.text = use_name
                    startActivity(intent)
                    finish()
                }*//*
                    "MBA" -> {
                        intent.putExtra(Constants.MBA, need.size.toString())
                        sixth = intent.getStringExtra(Constants.MBA).toString()
                    }
                    *//*{
                            val intent = Intent(this@MainActivity, MainActivity::class.java)
                            intent.putExtra(Constants.MBA, need.size.toString())
                            val use_name = intent.getStringExtra(Constants.MBA)
                            mba.text = use_name
                            startActivity(intent)
                            finish()
                        }*//*
                }
            }
            marketing.text = first
            business.text = second
            coding.text = third
            design.text = fourth
            analytic.text = fifth
            mba.text = sixth
            //startActivity(intent)
            //finish()*/
        }




        /*private fun showProgressDialog() {
            customProgressDialog = Dialog(this)
            customProgressDialog.setContentView(R.layout.dialog_custom_progress)
            customProgressDialog.show()
        }
        private fun cancelProgressDialog() {
            customProgressDialog.dismiss()
        }*/


    }

    // parsing json - end


}