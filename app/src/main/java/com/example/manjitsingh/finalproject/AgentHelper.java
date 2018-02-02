package com.example.manjitsingh.finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by manjitsingh on 2017-12-12.
 */

public class AgentHelper {
    private final EditText name;
    private final EditText level;
    private final EditText agency;
    private final EditText website;
    private final EditText country;
    private final EditText phone;
    private final EditText address;
    private final ImageView photo;
    private Agents beans;
    public AgentHelper(addagent addagent)
    {
        name=(EditText)addagent.findViewById(R.id.form_name);
        level=(EditText)addagent.findViewById(R.id.form_level);
        agency=(EditText)addagent.findViewById(R.id.form_agency);
        website=(EditText)addagent.findViewById(R.id.form_website);
        country=(EditText)addagent.findViewById(R.id.form_country);
        phone=(EditText)addagent.findViewById(R.id.form_phone);
        address=(EditText)addagent.findViewById(R.id.form_address);
        photo=(ImageView)addagent.findViewById(R.id.form_photo);

        beans=new Agents();
    }
    public AgentHelper(AssignMission addagent)
    {
        name=(EditText)addagent.findViewById(R.id.form_name);
        level=(EditText)addagent.findViewById(R.id.form_level);
        agency=(EditText)addagent.findViewById(R.id.form_agency);
        website=(EditText)addagent.findViewById(R.id.form_website);
        country=(EditText)addagent.findViewById(R.id.form_country);
        phone=(EditText)addagent.findViewById(R.id.form_phone);
        address=(EditText)addagent.findViewById(R.id.form_address);
        photo=(ImageView)addagent.findViewById(R.id.form_photo);

        beans=new Agents();
    }
    public Agents adgenthelper(){
        beans.setName(name.getText().toString());
        beans.setLevel(level.getText().toString());
        beans.setAgency(agency.getText().toString());
        beans.setWebsite(website.getText().toString());
        beans.setCountry(country.getText().toString());
        beans.setPhone(phone.getText().toString());
        beans.setAddress(address.getText().toString());
        beans.setPhotopath((String)photo.getTag());
        return beans;
    }
    public void fillform(Agents agents){
        name.setText(beans.getName());
        level.setText(beans.getLevel());
        agency.setText(beans.getAgency());
        website.setText(beans.getWebsite());
        country.setText(beans.getCountry());
        phone.setText(beans.getPhone());
        address.setText(beans.getAddress());
        loadImage(beans.getPhotopath());
        this.beans=beans;
    }
    public void loadImage(String dir){
        if(dir!=null){
            Bitmap bitmap= BitmapFactory.decodeFile(dir);
            Bitmap lowbit=Bitmap.createScaledBitmap(bitmap,300,300,true);
            photo.setImageBitmap(lowbit);
            photo.setScaleType(ImageView.ScaleType.FIT_XY);
            photo.setTag(dir);
        }
    }
}
