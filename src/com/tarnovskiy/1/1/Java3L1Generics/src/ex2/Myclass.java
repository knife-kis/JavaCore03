package ex2;

import java.util.ArrayList;
import java.util.List;

public class Myclass {

    List<?> numList = new ArrayList<Integer>();

    public List<?> getNumList() {
        return numList;
    }

    public void setNumList(List<?> numList) {
        this.numList = numList;
    }

    public void setStringGenericList(List<String> stringList){
        numList = stringList;
    }


}
