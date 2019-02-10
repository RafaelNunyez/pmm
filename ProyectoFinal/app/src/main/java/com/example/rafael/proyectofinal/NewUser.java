package com.example.rafael.proyectofinal;

import android.content.Context;
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


private EditText userInput;
private EditText passwordInput;
private Button createUser;
private Button cancelAction;
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
        createUser = view.findViewById(R.id.insertNewUser);
        cancelAction = view.findViewById(R.id.cancelAction);

        userInput = view.findViewById(R.id.fragmentUserInput);
        passwordInput = view.findViewById(R.id.fragmentPasswordInput);

        cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        createUser.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String nickNameInput = userInput.getText().toString();
                String passwordInput = NewUser.this.passwordInput.getText().toString();

                String user = "";
                String password = "";

                if (nickNameInput.equalsIgnoreCase("") || passwordInput.equalsIgnoreCase("")){
                    Toast.makeText(getContext(), "You have to insert a nickanem and a password", Toast.LENGTH_SHORT).show();
                    userInput.setText("");
                    NewUser.this.passwordInput.setText("");
                }
                for (int i = 0; i < arrayList.size();i++){
                    String value = (String) arrayList.get(i);
                    if(value.equalsIgnoreCase(userInput.getText().toString())){
                        checker = false;
                        Toast.makeText(getContext(), "The nickname is on use", Toast.LENGTH_SHORT).show();
                        userInput.setText("");
                        NewUser.this.passwordInput.setText("");
                        getDialog().dismiss();
                    }
                }
                if(checker){
                    ArrayList UserCreated = new ArrayList();
                    UserCreated.add(userInput.getText().toString());
                    UserCreated.add(NewUser.this.passwordInput.getText().toString());
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