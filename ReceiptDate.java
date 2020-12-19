import java.util.Date;
import java.util.Scanner;

public class ReceiptDate{
    private String receiptDate;

    public ReceiptDate(String date) {
        receiptDate = date;
    }

    public String getStringDate() {
        return receiptDate;
    }

    public int compareTo(ReceiptDate date){
        return receiptDate.compareTo(date.getStringDate());
    }

    public String toString(){
        String tmp = getStringDate();
        tmp = tmp.substring(4,6) + "/" + tmp.substring(6,8) + "/" + tmp.substring(0,4);
        return tmp;
    }

    public static ReceiptDate getDate(){
        Scanner cin = new Scanner(System.in);
        String ans, month, day, year;
        boolean validDate = false;
        ans = "";
        while (!validDate) {
            System.out.print("Enter Date MM/DD/YYYY: ");
            ans = cin.nextLine();
            month = ans.substring(0, ans.indexOf("/"));
            if (month.length() == 1)
                month = "0" + month;
            ans = ans.substring(ans.indexOf("/") + 1);
            day = ans.substring(0, ans.indexOf("/"));
            if (day.length() == 1)
                day = "0" + day;
            ans = ans.substring(ans.indexOf("/") + 1);
            year = ans;
            if (year.length() == 2)
                year = "20" + year;
            ans = year+month+day;
            if (ans.length() == 8)
                validDate = true;
        }
        return new ReceiptDate(ans);
    }
}
