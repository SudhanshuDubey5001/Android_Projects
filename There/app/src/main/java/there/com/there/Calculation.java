package there.com.there;

import java.util.ArrayList;
import java.util.List;

//    --------------------------------THIS IS CALCULATION SCREEN-----------------------------------------
//    -----------------------------------------------------------------------------------------------
public class Calculation extends MainActivity {
    private List<MainActivity> rich = new ArrayList<>();
    private List<MainActivity> poor = new ArrayList<>();
    private List<MainActivity> avg = new ArrayList<>();
    protected List<String> result = new ArrayList<>();
    private double noOfPeople;
    private double eachWillGive;
    private String name;
    private double Amount;

    public Calculation() {
        double totalAmount = 0;
        for (int i = 0; i < data.size(); i++) {
            totalAmount += (data.get(i)).amount;
        }
        System.out.println(totalAmount);
        noOfPeople = data.size();
        eachWillGive = totalAmount / noOfPeople;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).amount > eachWillGive) {
                rich.add(data.get(i));
            } else if (data.get(i).amount == eachWillGive) {
                avg.add(data.get(i));
            } else {
                poor.add(data.get(i));
            }
        }
        //Average people will give nothing and will get nothing
        //Rich people will only get something
        //Poor people will only give something

        int p_index = 0;    //poor index
        int r_index = 0;    //rich index

        if (rich.size() > 0 && poor.size() > 0) {
            double toGive = eachWillGive - (poor.get(p_index).amount);
            double toGet = rich.get(r_index).amount - eachWillGive;
            //determine how much to give by 1st poor
            //determine how much to get by 1st rich

            boolean isComplete;     //to end the loop
            while (true) {
                if (toGet - toGive > 0) {       //Poor will give whole
                    this.name = poor.get(p_index).name;
                    this.Amount = toGive;
                    this.willGive(rich.get(r_index).name);
                    toGet -= toGive;
                    p_index++;
                    isComplete = check(p_index, r_index);
                    if (!isComplete)
                        break;
                    toGive = eachWillGive - (poor.get(p_index).amount);
                } else if (toGet - toGive < 0) {        //poor will give to more than 1 person
                    this.name = poor.get(p_index).name;
                    this.Amount = toGet;
                    this.willGive(rich.get(r_index).name);
                    toGive -= toGet;
                    r_index++;
                    isComplete = check(p_index, r_index);
                    if (!isComplete)
                        break;
                    toGet = rich.get(r_index).amount - eachWillGive;
                } else {                                //poor will give exactly as needed by the rich
                    this.name = poor.get(p_index).name;
                    this.Amount = toGive; // or toGet
                    this.willGive(rich.get(r_index).name);
                    p_index++;
                    r_index++;
                    isComplete = check(p_index, r_index);
                    if (!isComplete)
                        break;
                    toGive = eachWillGive - (poor.get(p_index).amount);
                    toGet = rich.get(r_index).amount - eachWillGive;
                }
            }
        } else {
            System.out.println("Everything's good..");
            result.add("Everybody's HAPPY !!");
        }

    }


    private void willGive(String name) {
        System.out.println(this.name + " will give " + this.Amount + " to " + name);
        result.add(this.name + " will give " + Math.round(this.Amount) + " to " + name);
    }

    private boolean check(int pIndex, int rIndex) {
        if (pIndex >= poor.size() || rIndex >= rich.size())
            return false;
        else
            return true;
    }
}
