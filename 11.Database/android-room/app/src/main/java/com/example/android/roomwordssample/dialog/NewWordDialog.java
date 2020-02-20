package com.example.android.roomwordssample.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.android.roomwordssample.R;
import com.example.android.roomwordssample.database.tables.Word;

import java.util.Objects;

public class NewWordDialog extends DialogFragment {

    private Context context;
    private NewWordDialogCallback callback;

    public NewWordDialog(Context context, NewWordDialogCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void show(){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_add_new);

        TextView title = dialog.findViewById(R.id.edit_text_title);
        TextView description = dialog.findViewById(R.id.edit_text_description);
        NumberPicker numberPicker = dialog.findViewById(R.id.numberPicker);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        numberPicker.setMaxValue(100000);
        numberPicker.setMinValue(1);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onNewWord(new Word(title.getText().toString(), description.getText().toString(), numberPicker.getValue()));
                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public interface NewWordDialogCallback {
        void onNewWord(Word word);
    }
}
