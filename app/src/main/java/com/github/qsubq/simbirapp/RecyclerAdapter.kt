package com.github.qsubq.simbirapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.qsubq.simbirapp.databinding.TaskItemBinding

class RecyclerAdapter (val listener: Listener): RecyclerView.Adapter<RecyclerAdapter.TaskHolder>() {
    private val taskList = ArrayList<Task>()
    class TaskHolder(item : View) : RecyclerView.ViewHolder(item){
        val binding = TaskItemBinding.bind(item)

        fun bind (task : Task, listener: Listener){
            binding.titleTextId.text = task.title
            binding.timeTextId.text = task.time
            itemView.setOnClickListener{
                listener.onClick(task)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskHolder(view)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(taskList[position], listener)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    fun addAll(list: List<Task>){
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()

    }

    interface Listener{
        fun onClick(task: Task)



    }
}