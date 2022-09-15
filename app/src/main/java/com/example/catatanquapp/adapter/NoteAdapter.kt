package com.example.catatanquapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catatanquapp.databinding.AdapterMainBinding
import com.example.catatanquapp.db.Note

class NoteAdapter (private var notes: ArrayList<Note>, private val listener: OnAdapterListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            AdapterMainBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        )

    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.textTitle.text = note.title
        holder.binding.textTitle.setOnClickListener {
            listener.onRead(note)
        }
        holder.binding.iconEdit.setOnClickListener {
            listener.onUpdate(note)
        }
        holder.binding.iconDelete.setOnClickListener {
            listener.onDelete(note)
        }

    }

    inner class NoteViewHolder(val binding: AdapterMainBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(newList: List<Note>) {
        notes.clear()
        notes.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onRead(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }
}