package com.example.thingsboardalarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.ActionBar
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import kotlinx.android.synthetic.main.activity_main.view.*
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val ROWS = 10
    val COLUMNS = 5
    val tableLayout by lazy { TableLayout(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "ROWS : $ROWS COLUMNS: $COLUMNS"


        val lp = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        tableLayout.apply {
            layoutParams = lp
            isShrinkAllColumns = true
        }


        createTable(ROWS, COLUMNS)
    }

    fun createTable(rows: Int, cols: Int) {

        for (i in 0 until rows) {

            val row = TableRow(this)
            row.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            for (j in 0 until cols) {

                val button = Button(this)
                button.apply {
                    layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT)
                    text = "R $i C $j"
                }
                row.addView(button)
            }
            tableLayout.addView(row)
        }
        linearLayout.addView(tableLayout)
    }





}
