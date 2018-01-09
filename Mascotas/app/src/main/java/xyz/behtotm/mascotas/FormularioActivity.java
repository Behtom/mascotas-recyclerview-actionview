package xyz.behtotm.mascotas;

import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener {

    private Button enviar;
    private EditText correo;
    private EditText mensaje;
    private EditText nombre;
    private String fromUsuario = "/*Aquí tu correo electrónico*/";
    private String fromContrasenia = "/*Aquí tu contraseña*/";
    private TextInputLayout inputCorreo;
    private TextInputLayout inputMensaje;
    private TextInputLayout inputNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        setActionBar();

        correo = (EditText) findViewById(R.id.activity_formulario_correo);
        enviar= (Button) findViewById(R.id.activity_formulario_enviar);
        enviar.setOnClickListener(this);
        inputCorreo = (TextInputLayout) findViewById(R.id.activity_formulario_input_correo);
        inputMensaje = (TextInputLayout) findViewById(R.id.activity_formulario_input_mensaje);
        inputNombre = (TextInputLayout) findViewById(R.id.activity_formulario_input_nombre);
        mensaje = (EditText) findViewById(R.id.activity_formulario_mensaje);
        nombre = (EditText) findViewById(R.id.activity_formulario_nombre);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.activity_formulario_enviar:

                String etCorreo = correo.getText().toString();
                String etMensaje = mensaje.getText().toString();
                String etNombre = nombre.getText().toString();

                if(TextUtils.isEmpty(etCorreo)) {
                    inputCorreo.setError(getString(R.string.formulario_correo_vacío));
                    inputCorreo.setErrorEnabled(true);
                } else {
                    inputCorreo.setErrorEnabled(false);
                }
                if(TextUtils.isEmpty(etMensaje)) {
                    inputMensaje.setError(getString(R.string.formulario_mensaje_vacio));
                    inputMensaje.setErrorEnabled(true);
                } else {
                    inputMensaje.setErrorEnabled(false);
                }
                if(TextUtils.isEmpty(etNombre)) {
                    inputNombre.setError(getString(R.string.formulario_nombre_vacio));
                    inputNombre.setErrorEnabled(true);
                } else {
                    inputNombre.setErrorEnabled(false);
                }
                if(!TextUtils.isEmpty(etCorreo) && !TextUtils.isEmpty(etMensaje) && !TextUtils.isEmpty(etNombre)) {
                    sendEmail();
                }
                break;
        }
    }

    private void sendEmail() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFacroty.port", "465");
        props.put("mail.smtp.socketFacroty.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromUsuario, fromContrasenia);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromUsuario));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo.getText().toString()));
            msg.setSubject("De: " + nombre.getText().toString());
            msg.setContent(mensaje.getText().toString(), "text/html; charset=utf-8");
            Transport.send(msg);
            /*
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",465,fromUsuario, fromContrasenia);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            */
            Toast.makeText(this, "Enviado", Toast.LENGTH_SHORT).show();
        } catch (MessagingException | NetworkOnMainThreadException e) {
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    private void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_formulario_toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar ab = getSupportActionBar();
            ab.setTitle(R.string.form_title);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setIcon(R.drawable.ic_pets);
        }
    }
}
