package com.example.rafael.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class NewUser extends DialogFragment {


private EditText UserInput;
private EditText PasswordInput;
private Button CreateUser;
private Button CancelAction;
        ArrayList arrayList;
        Boolean checker = true;

public interface OnInputListener{
    void sendInput(ArrayList arrayList);
}
    public OnInputListener onInputListener;

    static NewUser newInstance(ArrayList arrayList){
        NewUser dialogFragmentNewUser = new NewUser();
        Bundle args = new Bundle();
        args.putParcelableArrayList("UserArray",arrayList);
        dialogFragmentNewUser.setArguments(args);
        return dialogFragmentNewUser;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList = getArguments().getParcelableArrayList("UserArray");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_user, container, false);
        CreateUser = view.findViewById(R.id.InsertNewUser);
        CancelAction = view.findViewById(R.id.CancelAction);

        UserInput = view.findViewById(R.id.FragmentUserInput);
        PasswordInput = view.findViewById(R.id.FragmentPasswordInput);

        CancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        CreateUser.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String nickNameInput = UserInput.getText().toString();
                String passwordInput = PasswordInput.getText().toString();

                String user = "";
                String password = "";
                String mail = "";

                if(nickNameInput.equalsIgnoreCase("") || passwordInput.equalsIgnoreCase("")){
                    Toast.makeText(getContext(), "You have to insert a nickanem and a password", Toast.LENGTH_SHORT).show();
                    UserInput.setText("");
                    PasswordInput.setText("");
                }
                for(int i = 0; i < arrayList.size();i++){
                    String value = (String) arrayList.get(i);
                    if(value.equalsIgnoreCase(UserInput.getText().toString())){
                        checker = false;
                        Toast.makeText(getContext(), "The nickname is on use", Toast.LENGTH_SHORT).show();
                        UserInput.setText("");
                        PasswordInput.setText("");
                    }
                }
                if(checker){
                    ArrayList UserCreated = new ArrayList();
                    UserCreated.add(UserInput.getText().toString());
                    UserCreated.add(PasswordInput.getText().toString());
                    onInputListener.sendInput(UserCreated);
                    getDialog().dismiss();
                }else{
                    Toast.makeText(getContext(), "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onInputListener = (OnInputListener) getActivity();
        }catch(ClassCastException e){
            Toast.makeText(getContext(), "Sending error", Toast.LENGTH_SHORT ).show();
        }
    }
}