package com.example.periodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 class FAQsAdapter extends RecyclerView.Adapter<FAQsAdapter.ViewHolder> {

    private ArrayList<Questions> questionList; //To hold array of questions
    private Context context;

    //Constructor
    public FAQsAdapter(Context context, ArrayList<Questions> questionsArrayList) {
        this.context = context;
        this.questionList = questionsArrayList;
    }

    @NonNull
    @Override
    public FAQsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Connects list items
        return new ViewHolder((LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull FAQsAdapter.ViewHolder holder, int position) {
        Questions currQuestion = questionList.get(position); //gets position of current question in arrayList
        holder.bindItem(currQuestion);
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView questionTitle;
        private TextView answer;

        public ViewHolder(View itemView) {
            super(itemView);

            //Connects java to the list_items.xml
            questionTitle = itemView.findViewById(R.id.question_title);
            answer = itemView.findViewById(R.id.answer);
            //set onClickListener
        }

        public void bindItem(Questions currentQuestion) {
            questionTitle.setText(currentQuestion.getQuestion());
            answer.setText(currentQuestion.getAnswer());
        }

        //Need to make sure we grab appropriate text to bind an item

    } //end of ViewHolder
}
