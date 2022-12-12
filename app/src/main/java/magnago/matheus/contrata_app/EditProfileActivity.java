package magnago.matheus.contrata_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import magnago.matheus.contrata_app.Util.ImageCache;
import magnago.matheus.contrata_app.fragment.ProfileFragment;
import magnago.matheus.contrata_app.permissoes.Permissao;

public class EditProfileActivity extends AppCompatActivity {

    private Button btnEdit1;
    private static final int altCamera = 100;
    private static final int altGaleria = 200;
    private CircleImageView CircleImgProfile;

    public String[] permissoesNecessarias = new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };


    private ImageButton imbEditCamera, imbEditGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        imbEditGallery = findViewById(R.id.imbEdit1);
        imbEditCamera = findViewById(R.id.imbEdit2);
        btnEdit1 = findViewById(R.id.btnEditProf1);
        CircleImgProfile = findViewById(R.id.imvEditProf1);

        Toolbar tbSet = findViewById(R.id.tbarHome);


        Permissao.validarPermissoes(permissoesNecessarias, this, 1);

        imbEditGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //if (i1.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i1, altGaleria);
                //}
            }
        });

        imbEditCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //if (i2.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i2, altCamera);
                //}
            }
        });

        btnEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(i3);
            }
        });

        tbSet.setTitle("Editar Perfil");
        setSupportActionBar(tbSet);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Bitmap imagem = null;

            try {
                switch (requestCode) {
                    case altCamera:
                        imagem = (Bitmap) data.getExtras().get("data");
                        break;
                    case altGaleria:
                        Uri localImgSelec = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImgSelec);
                        break;
                }
                if (imagem != null) {
                    CircleImgProfile.setImageBitmap(imagem);

                    byte[] fotoByte;
                    ByteArrayOutputStream streamFotoByte = new ByteArrayOutputStream();

                    imagem.compress(Bitmap.CompressFormat.PNG, 75, streamFotoByte);
                    fotoByte = streamFotoByte.toByteArray();
                    String fotoString = Base64.encodeToString(fotoByte, Base64.DEFAULT);

                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editprofile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.backEditProfile:
                //Configurações;
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int permissaoResultado:grantResults) {

            if (permissaoResultado == PackageManager.PERMISSION_DENIED) {
                alertaPermissao();
            }
        }

    }

    private void alertaPermissao() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para o correto funcionamento do app CONTRATAAÍ é necessário aceitar as devidas permissões solicitadas.");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}