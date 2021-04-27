package filemanager.component;

import filemanager.exceptions.NumberOfParamsException;
import filemanager.exceptions.ParametersFormatException;

import java.util.ArrayList;

public class ComponentFactory {
    public static Component getComponent(ArrayList<String> params) throws NumberOfParamsException, ParametersFormatException {
        try {
            switch (params.get(0)) {
                case "Diode":
                    if(params.size() > 2 && params.size() < 5)
                        return new Diode(Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)), params.size() > 3 ? Integer.parseInt(params.get(3)) : 0);
                    else
                        throw new NumberOfParamsException();

                case "XORGate":
                    // itd
                default:
                    return null;
            }
        }catch(NumberFormatException e){
            throw new ParametersFormatException();
        }
    }

}
