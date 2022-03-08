package com.github.qsubq.simbirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.github.qsubq.simbirapp.databinding.ActivityMainBinding
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.Listener {
    lateinit var binding: ActivityMainBinding
    private val adapter = RecyclerAdapter(this)

    private var taskList = ArrayList<Task>()
    private val firstTask = JSONObject()

    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.ENGLISH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jsonCreateInstance()
        setupCalendar()
        initRecyclerView()
    }


    private fun setupCalendar() {
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            binding.dateText.text = msg

            getTaskList()

            adapter.addAll(taskList)
            taskList.clear()
        }
    }

    private fun initRecyclerView() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
        }
    }

    private fun getTaskList(){
        taskList.add(Task("06 : 00 - 07 : 00", ""))
        taskList.add(Task("07 : 00 - 08 : 00", "Feed the cat"))
        taskList.add(Task("08 : 00 - 09 : 00", ""))
        taskList.add(Task("09 : 00 - 10 : 00", "take a shower"))
        taskList.add(Task("10 : 00 - 11 : 00", ""))
        taskList.add(Task("11 : 00 - 12 : 00", ""))
        taskList.add(Task("12 : 00 - 13 : 00", ""))
        taskList.add(Task("13 : 00 - 14 : 00", "Feed the cat again"))
        taskList.add(Task("14 : 00 - 15 : 00", ""))
        taskList.add(Task("15 : 00 - 16 : 00", ""))
        taskList.add(Task("16 : 00 - 17 : 00", ""))
        taskList.add(Task("17 : 00 - 18 : 00", ""))
        taskList.add(Task("18 : 00 - 19 : 00", ""))
        taskList.add(Task("19 : 00 - 20 : 00", ""))
        taskList.add(Task("21 : 00 - 22 : 00", ""))
    }

    private fun jsonCreateInstance(){
        firstTask.put("id","1")
        firstTask.put("date_start","")
        firstTask.put("date_finish","")
        firstTask.put("name","My task")
        firstTask.put("description", "Description of my task")
    }

    private fun getDateString(time: Int) : String = simpleDateFormat.format(time * 1000L)

    override fun onClick(task: Task) {

    }


}

