/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gigabyte_scratch;

/**
 *
 * @author jaski
 */
public class ModelTable {
    
    String Name;
    int Number;

    public ModelTable(String Name, int Number) {
        this.Name = Name;
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }
    
    
    
}
