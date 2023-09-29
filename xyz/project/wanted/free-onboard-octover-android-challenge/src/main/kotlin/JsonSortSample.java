
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.stream.Collectors;

public class JsonSortSample {

    public JsonSortSample() {
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            //파일경로 
            String filePath = "q4-sort.json";

            Q4Main q4Main = objectMapper.readValue(new File(filePath), Q4Main.class);
            
            //정렬
            List<Q4Sub> q4Subs=q4Main.getItems()
                    .stream()
                    .sorted(Comparator.comparingInt(Q4Sub::getPrice).reversed())
                    .collect(Collectors.toList());

            for(Q4Sub q4sub : q4Subs){
                System.out.println("q4Sub price"+q4sub.getPrice());
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

class Q4Main {

    private List<Q4Sub> items;


    public void setItems(List<Q4Sub> items) {
        this.items = items;
    }

    public List<Q4Sub> getItems() {
        return items;
    }
}
class Q4Sub {

    private String label;

    private Integer price;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
