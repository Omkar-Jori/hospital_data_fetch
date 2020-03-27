package com.example.atlanticare;

class Contents {

    String description,charge;
    public Contents(String description,String charge)
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
