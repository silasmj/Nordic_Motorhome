package com.example.nordic_motorhome.Model;

public class Return extends Rental{
    int rental_id;
    String rental_end;
    String drop_off;
    int drop_off_extras;
    int kmEnd;
    int repair_fee;
    float fuel_level;
    int full_price;

    public Return(int rental_id, int customer_id, int motorhome_id, String rental_start, int bike_rack, int bed_linen, int chairs, int picnic_table, int child_seat, String pick_up, String pick_up_extra, int km_start, String season, int rental_id1, String rental_end, String drop_off, int drop_off_extras, int kmEnd, int repair_fee, float fuel_level, int full_price) {
        super(rental_id, customer_id, motorhome_id, rental_start, bike_rack, bed_linen, chairs, picnic_table, child_seat, pick_up, pick_up_extra, km_start, season);
        this.rental_id = rental_id;
        this.rental_end = rental_end;
        this.drop_off = drop_off;
        this.drop_off_extras = drop_off_extras;
        this.kmEnd = kmEnd;
        this.repair_fee = repair_fee;
        this.fuel_level = fuel_level;
        this.full_price = full_price;
    }
    public Return(int rental_id, int customer_id, int motorhome_id, String rental_start, int bike_rack, int bed_linen, int chairs, int picnic_table, int child_seat, String pick_up, String pick_up_extra, int km_start, String season,  String rental_end, String drop_off) {
        super(rental_id, customer_id, motorhome_id, rental_start, bike_rack, bed_linen, chairs, picnic_table, child_seat, pick_up, pick_up_extra, km_start, season);
        this.rental_end = rental_end;
        this.drop_off = drop_off;

    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public String getRental_end() {
        return rental_end;
    }

    public void setRental_end(String rental_end) {
        this.rental_end = rental_end;
    }

    public String getDrop_off() {
        return drop_off;
    }

    public void setDrop_off(String drop_off) {
        this.drop_off = drop_off;
    }

    public int getDrop_off_extras() {
        return drop_off_extras;
    }

    public void setDrop_off_extras(int drop_off_extras) {
        this.drop_off_extras = drop_off_extras;
    }

    public int getKmEnd() {
        return kmEnd;
    }

    public void setKmEnd(int kmEnd) {
        this.kmEnd = kmEnd;
    }

    public int getRepair_fee() {
        return repair_fee;
    }

    public void setRepair_fee(int repair_fee) {
        this.repair_fee = repair_fee;
    }

    public double getFuel_level() {
        return fuel_level;
    }

    public void setFuel_level(float fuel_level) {
        this.fuel_level = fuel_level;
    }

    public int getFull_price() {
        return full_price;
    }

    public void setFull_price(int full_price) {
        this.full_price = full_price;
    }
}
