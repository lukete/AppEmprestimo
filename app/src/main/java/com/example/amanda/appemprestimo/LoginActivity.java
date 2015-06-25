package com.example.amanda.appemprestimo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

    // Objetos necessários
    Amigo amigo;

    // Declarando Variaveis
    EditText edtUsuario;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        amigo = new Amigo();
        // Recuperando Objetos
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha   = (EditText) findViewById(R.id.edtSenha);

        Button btnEntrar    = (Button) findViewById(R.id.btnEntrar);
        final Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        // AÇÕES BOTOES
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // VALIDA SE USUARIO EXISTE
                if(!amigo.existe_amigo(edtUsuario.getText().toString())){
                    // Mensagem
                    Toast msg = Toast.makeText(getBaseContext(), "Usuário não existe", Toast.LENGTH_SHORT);
                    msg.show();
                }
                else{
                    // Chama ACTIVITY PRINCIPAL
                    Intent principal = new Intent(LoginActivity.this, PrincipalActivity.class);
                    startActivity(principal);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
