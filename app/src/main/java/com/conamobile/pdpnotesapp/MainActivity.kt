package com.conamobile.pdpnotesapp

import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.pdpnotesapp.adapter.NotesAdapter
import com.conamobile.pdpnotesapp.memory.MySharedPrefarance
import com.conamobile.pdpnotesapp.model.Time
import com.google.android.material.floatingactionbutton.FloatingActionButton

lateinit var buttonAdd: FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: NotesAdapter
    var textList: ArrayList<String> = ArrayList()

    override fun onStart() {
        super.onStart()
//        loadData()
//        setInsertButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
    }


    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewAdapter = NotesAdapter(this, textList)
        recyclerView.adapter = recyclerViewAdapter

        buttonAdd = findViewById(R.id.add_button)

        buttonAdd.setOnClickListener {
            showAlertDialog()
        }

    }

//    private fun saveData() {
//        val sharedPrefarance: SharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPrefarance.edit()
//        val gson = Gson()
//        val json = gson.toJson(mExampleList)
//        editor.putString("task list", json)
//        editor.apply()
//    }
//
//    private fun loadData() {
//        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
//        val gson = Gson()
//        val json = sharedPreferences.getString("task list", null)
//        val type:Type = object:TypeToken<ArrayList<Story>>(){}.getType()
//        mExampleList = gson.fromJson(json, type)
//
//        if (mExampleList == null) {
//            mExampleList = ArrayList()
//        }
//    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)

        val view = LayoutInflater.from(this)
            .inflate(R.layout.customview_dialog, this.findViewById(R.id.layoutDialog))
        builder.setView(view)

        val alertDialog: AlertDialog = builder.create()

        view.findViewById<TextView>(R.id.cancel_btn).setOnClickListener {
            alertDialog.dismiss()
        }


        view.findViewById<TextView>(R.id.save_btn).setOnClickListener {

        val editText = view.findViewById<EditText>(R.id.textMessage)
            if (editText?.text.toString() != "") {
                alertDialog.dismiss()
                textList.add(0, editText.text.toString())
                MySharedPrefarance(this).isSavedList(editText?.text.toString())
                recyclerViewAdapter.notifyDataSetChanged()

            }
        }

        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        alertDialog.setCancelable(true)

        alertDialog.show()
    }

//    private fun setInsertButton() {
//        buttonAdd.setOnClickListener {
//            val line1 = editText
//            insertItem(line1.text.toString())
//        }
//    }
//
//    private fun insertItem(line1: String) {
//        mExampleList.add(Story(line1, line1))
//        recyclerViewAdapter.notifyItemInserted(mExampleList.size)
//    }

}