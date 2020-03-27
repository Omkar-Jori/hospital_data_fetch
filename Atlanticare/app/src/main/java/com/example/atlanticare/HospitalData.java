package com.example.atlanticare;

public class HospitalData {
    private String description;
    private String  charge;

    public HospitalData(String description, String charge)
    {
        this.description=description;
        this.charge=charge;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public String getCharge()
    {
        return charge;
    }

    public void setCharge(String charge)
    {
        this.charge=charge;
    }
}
