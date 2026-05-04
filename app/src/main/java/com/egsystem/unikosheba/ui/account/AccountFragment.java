package com.egsystem.unikosheba.ui.account;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.credential.LoginActivity;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.databinding.FragmentAccountBinding;
import com.egsystem.unikosheba.model.UserAccountModel;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;
//import com.egsystem.unikosheba.ui.account.edit_profile.EditProfileActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;
    Context context;
    String storagepath = "Users_Profile_Cover_image/";
    String uid;
    ImageView set;
    TextView profilepic, editname, editpassword;
    ProgressDialog pd;
    private static final int CAMERA_REQUEST = 100;
    private static final int STORAGE_REQUEST = 200;
    private static final int IMAGEPICK_GALLERY_REQUEST = 300;
    private static final int IMAGE_PICKCAMERA_REQUEST = 400;
    String cameraPermission[];
    String storagePermission[];
    Uri imageuri;
    String profileOrCoverPhoto;


    String name = "";
    String phone = "";
    String email = "";
    String date_of_birth = "";
    String adddress = "";
    String gender = "";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initActionbar();
        initComponents();

//        final TextView textView = binding.textDashboard;
        userAccount("");

        return root;
    }

    private void initActionbar() {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("tag1111134", " onResume is called" );

//        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        userAccount("");

    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("tag1111134", " onStop is called" );
//        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
//        userAccount("");
    }


    private void initComponents() {


        pd = new ProgressDialog(context);
        pd.setCanceledOnTouchOutside(false);


        binding.tvEditProfile.setOnClickListener(v -> {
//            Intent intent = new Intent(context, EditProfileActivity.class);
//            context.startActivity(intent);
        });

        binding.linearLogout.setOnClickListener(v -> {
            SharedData.saveIS_USER_LOGGED_IN(context, false);
            Intent intent = new Intent(context, LoginActivity.class);
            intent.putExtra("from_where", "account_fragment");
            startActivity(intent);
            getActivity().finish();
        });


        binding.linearLogout.setOnClickListener(v -> {
            cameraPermissionCall();
        });

        ///


//        editpassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pd.setMessage("Changing Password");
//                showPasswordChangeDailog();
//            }
//        });
//
//        profilepic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pd.setMessage("Updating Profile Picture");
//                profileOrCoverPhoto = "image";
//                showImagePicDialog();
//            }
//        });
//
//        editname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pd.setMessage("Updating Name");
//                showNamephoneupdate("name");
//            }
//        });


    }

    private void cameraPermissionCall() {
        cameraPermission = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//
//
//
//
//            Query query = databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
//            query.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                        String image = "" + dataSnapshot1.child("image").getValue();
//
//                        try {
//                            Glide.with(EditProfilePage.this).load(image).into(set);
//                        } catch (Exception e) {
//                        }
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//
//        }

//        @Override
//        protected void onPause() {
//            super.onPause();
//            Query query = databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
//            query.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                        String image = "" + dataSnapshot1.child("image").getValue();
//
//                        try {
//                            Glide.with(EditProfilePage.this).load(image).into(set);
//                        } catch (Exception e) {
//                        }
//
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//            editpassword.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pd.setMessage("Changing Password");
//                    showPasswordChangeDailog();
//                }
//            });
//        }

//        @Override
//        protected void onStart() {
//            super.onStart();
//            Query query = databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
//            query.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                        String image = "" + dataSnapshot1.child("image").getValue();
//
//                        try {
//                            Glide.with(EditProfilePage.this).load(image).into(set);
//                        } catch (Exception e) {
//                        }
//
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//            editpassword.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pd.setMessage("Changing Password");
//                    showPasswordChangeDailog();
//                }
//            });
//        }

    // checking storage permission ,if given then we can add something in our storage
    private Boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    // requesting for storage permission
    private void requestStoragePermission() {
        requestPermissions(storagePermission, STORAGE_REQUEST);
    }

    // checking camera permission ,if given then we can click image using our camera
    private Boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    // requesting for camera permission if not given
    private void requestCameraPermission() {
        requestPermissions(cameraPermission, CAMERA_REQUEST);
    }

    // We will show an alert box where we will write our old and new password
    private void showPasswordChangeDailog() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_update_password, null);
        final EditText oldpass = view.findViewById(R.id.oldpasslog);
        final EditText newpass = view.findViewById(R.id.newpasslog);
        Button editpass = view.findViewById(R.id.updatepass);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        editpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldp = oldpass.getText().toString().trim();
                String newp = newpass.getText().toString().trim();
                if (TextUtils.isEmpty(oldp)) {
                    Toast.makeText(context, "Current Password cant be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(newp)) {
                    Toast.makeText(context, "New Password cant be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                dialog.dismiss();
//                    updatePassword(oldp, newp);
            }
        });
    }

    // Now we will check that if old password was authenticated
    // correctly then we will update the new password
//        private void updatePassword(String oldp, final String newp) {
//            pd.show();
//            final FirebaseUser user = firebaseAuth.getCurrentUser();
//            AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), oldp);
//            user.reauthenticate(authCredential)
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            user.updatePassword(newp)
//                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                        @Override
//                                        public void onSuccess(Void aVoid) {
//                                            pd.dismiss();
//                                            Toast.makeText(EditProfilePage.this, "Changed Password", Toast.LENGTH_LONG).show();
//                                        }
//                                    }).addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            pd.dismiss();
//                                            Toast.makeText(EditProfilePage.this, "Failed", Toast.LENGTH_LONG).show();
//                                        }
//                                    });
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            pd.dismiss();
//                            Toast.makeText(EditProfilePage.this, "Failed", Toast.LENGTH_LONG).show();
//                        }
//                    });
//        }

    // Updating name
    private void showNamephoneupdate(final String key) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Update" + key);

        // creating a layout to write the new name
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10, 10, 10, 10);
        final EditText editText = new EditText(context);
        editText.setHint("Enter" + key);
        layout.addView(editText);
        builder.setView(layout);

        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String value = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(value)) {
                    pd.show();

//                        // Here we are updating the new name
//                        HashMap<String, Object> result = new HashMap<>();
//                        result.put(key, value);
//                        databaseReference.child(firebaseUser.getUid()).updateChildren(result).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                pd.dismiss();
//
//                                // after updated we will show updated
//                                Toast.makeText(EditProfilePage.context, " updated ", Toast.LENGTH_LONG).show();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                pd.dismiss();
//                                Toast.makeText(EditProfilePage.context, "Unable to update", Toast.LENGTH_LONG).show();
//                            }
//                        });
//                        if (key.equals("name")) {
//                            final DatabaseReference databaser = FirebaseDatabase.getInstance().getReference("Posts");
//                            Query query = databaser.orderByChild("uid").equalTo(uid);
//                            query.addValueEventListener(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                                        String child = databaser.getKey();
//                                        dataSnapshot1.getRef().child("uname").setValue(value);
//                                    }
//                                }
//
//                                @Override
//                                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                }
//                            });
//                        }
                } else {
                    Toast.makeText(context, "Unable to update", Toast.LENGTH_LONG).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pd.dismiss();
            }
        });
        builder.create().show();
    }

    // Here we are showing image pic dialog where we will select
    // and image either from camera or gallery
    private void showImagePicDialog() {
        String options[] = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pick Image From");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // if access is not given then we will request for permission
                if (which == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermission();
                    } else {
                        pickFromCamera();
                    }
                } else if (which == 1) {
                    if (!checkStoragePermission()) {
                        requestStoragePermission();
                    } else {
                        pickFromGallery();
                    }
                }
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == IMAGEPICK_GALLERY_REQUEST) {
                imageuri = data.getData();
//                    uploadProfileCoverPhoto(imageuri);
            }
            if (requestCode == IMAGE_PICKCAMERA_REQUEST) {
//                    uploadProfileCoverPhoto(imageuri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST: {
                if (grantResults.length > 0) {
                    boolean camera_accepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writeStorageaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (camera_accepted && writeStorageaccepted) {
                        pickFromCamera();
                    } else {
                        Toast.makeText(context, "Please Enable Camera and Storage Permissions", Toast.LENGTH_LONG).show();
                    }
                }
            }
            break;
            case STORAGE_REQUEST: {
                if (grantResults.length > 0) {
                    boolean writeStorageaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (writeStorageaccepted) {
                        pickFromGallery();
                    } else {
                        Toast.makeText(context, "Please Enable Storage Permissions", Toast.LENGTH_LONG).show();
                    }
                }
            }
            break;
        }
    }

    // Here we will click a photo and then go to startactivityforresult for updating data
    private void pickFromCamera() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE, "Temp_pic");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION, "Temp Description");
        imageuri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        Intent camerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camerIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
        startActivityForResult(camerIntent, IMAGE_PICKCAMERA_REQUEST);
    }

    // We will select an image from gallery
    private void pickFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGEPICK_GALLERY_REQUEST);
    }

    // We will upload the image from here.
//        private void uploadProfileCoverPhoto(final Uri uri) {
//            pd.show();
//
//            // We are taking the filepath as storagepath + firebaseauth.getUid()+".png"
//            String filepathname = storagepath + "" + profileOrCoverPhoto + "_" + firebaseUser.getUid();
//            StorageReference storageReference1 = storageReference.child(filepathname);
//            storageReference1.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
//                    while (!uriTask.isSuccessful()) ;
//
//                    // We will get the url of our image using uritask
//                    final Uri downloadUri = uriTask.getResult();
//                    if (uriTask.isSuccessful()) {
//
//                        // updating our image url into the realtime database
//                        HashMap<String, Object> hashMap = new HashMap<>();
//                        hashMap.put(profileOrCoverPhoto, downloadUri.toString());
//                        databaseReference.child(firebaseUser.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                pd.dismiss();
//                                Toast.makeText(EditProfilePage.context, "Updated", Toast.LENGTH_LONG).show();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                pd.dismiss();
//                                Toast.makeText(EditProfilePage.context, "Error Updating ", Toast.LENGTH_LONG).show();
//                            }
//                        });
//                    } else {
//                        pd.dismiss();
//                        Toast.makeText(EditProfilePage.context, "Error", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    pd.dismiss();
//                    Toast.makeText(EditProfilePage.context, "Error", Toast.LENGTH_LONG).show();
//                }
//            });
//        }


    @SuppressLint("CheckResult")
    public void userAccount(String id) {

//        showProgressDialog();

        String token = SharedData.getTOKEN(context);
        Log.d("tag11111", " token: " + token);
        Log.d("tag11111", " id: " + id);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().show_user_account(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

//                            closeProgressDialog();

                            Log.d("tag1111134", " response.code(): " + response.code());
                            Log.d("tag11111", " response.code(): " + response.code());
                            Log.d("tag11111", " response.toString(): " + response.toString());


                            if (response.code() == 401) {
                                Intent intent = new Intent(context, LoginActivity.class);
                                intent.putExtra("SENDER_ACTIVITY_NAME", "");
                                startActivity(intent);
                            }


                            if (response.isSuccessful()) {



                                UserAccountModel model = response.body();
                                Log.d("tag11111", " response.body(): " + response.body());

                                boolean success = model.getSuccess();
                                Log.d("tag11111", " show_user_account success: " + success);

                                name = model.getResult().getName();
                                phone = model.getResult().getMobileNumber();


                                binding.tvName.setText(name);
                                binding.tvMobileNumber.setText(phone);

                                if (model.getResult().getEmail() != null) {
                                    email = model.getResult().getEmail();

                                    if (email.isEmpty()){
                                        binding.tvEmail.setText("Email is not set yet");
                                    }else {
                                        binding.tvEmail.setText(email);
                                        SharedData.saveEMAIL(context, email);
                                    }



                                } else {
                                    binding.tvEmail.setText("Email is not set yet");
                                }


                                if (model.getResult().getDateOfBirth() != null) {
                                    date_of_birth = model.getResult().getDateOfBirth();
                                    binding.tvDob.setText(date_of_birth);
                                    SharedData.saveDOB(context, date_of_birth);
                                } else {
                                    binding.tvDob.setText("Date of birth is not set yet");
                                }


                                if (model.getResult().getAddress() != null) {
                                    adddress = model.getResult().getAddress();
                                    binding.tvAddress.setText(adddress);
                                    SharedData.savePRESENT_ADDRESS(context, adddress);
                                } else {
                                    binding.tvAddress.setText("Address is not set yet");
                                }


                                if (model.getResult().getGender() != null) {
                                    gender = model.getResult().getGender();
                                    binding.tvGender.setText(gender);
                                    SharedData.saveGENDER(context, gender);
                                } else {
                                    binding.tvGender.setText("Gender is not set yet");
                                }


                                String imageUrl = model.getResult().getProfileImage();
                                Glide.with(this).load(imageUrl).into(binding.ivProfileImage);


//                                if (response.code() == 200) {
//
//
//
//                                } else {
////                                    new MaterialDialog.Builder(context)
////                                            .title("Status")
////                                            .content("List is empty....")
////                                            .positiveText("")
////                                            .negativeText("Ok")
////                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
////                                                @Override
////                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
////
////                                                }
////                                            })
////                                            .show();
//                                }

                            } else {

                            }


                        },
                        error -> {

                            Log.d("tag11111", " response.code(): " + error.toString());

                        },
                        () -> {

                        }
                );


    }


    ProgressDialog progressDialog;

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait ....");
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }


}



