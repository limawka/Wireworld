package filemanager.component;

import filemanager.exceptions.ComponentRotationException;
import filemanager.exceptions.NumberOfParamsException;
import filemanager.exceptions.ParametersFormatException;

import java.util.ArrayList;

public class ComponentFactory {
    public static Component getComponent(ArrayList<String> params) throws NumberOfParamsException, ParametersFormatException, ComponentRotationException {
        try {
            switch (params.get(0)) {
                case "Diode":
                    if(params.size() > 2 && params.size() < 5)
                        return new Diode(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2)),
                                params.size() > 3 ? Integer.parseInt(params.get(3)) : 0
                        );
                    else
                        throw new NumberOfParamsException();

                case "ANDGate":
                    if(params.size() > 2 && params.size() < 5)
                        return new ANDGate(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2)),
                                params.size() > 3 ? Integer.parseInt(params.get(3)) : 0
                        );
                    else
                        throw new NumberOfParamsException();
                case "ORGate":
                    if(params.size() > 2 && params.size() < 5)
                        return new ORGate(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2)),
                                params.size() > 3 ? Integer.parseInt(params.get(3)) : 0
                        );
                    else
                        throw new NumberOfParamsException();
                case "XORGate":
                    if(params.size() > 2 && params.size() < 5)
                        return new XORGate(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2)),
                                params.size() > 3 ? Integer.parseInt(params.get(3)) : 0
                        );
                    else
                        throw new NumberOfParamsException();
                case "Clock":
                    if(params.size() > 2 && params.size() < 5)
                        return new Clock(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2)),
                                params.size() > 3 ? Integer.parseInt(params.get(3)) : 0
                        );
                    else
                        throw new NumberOfParamsException();
                case "ElectronTail":
                    if(params.size() == 3)
                        return new ElectronTail(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2))
                        );
                    else
                        throw new NumberOfParamsException();
                case "ElectronHead":
                    if(params.size() == 3)
                        return new ElectronHead(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2))
                        );
                    else
                        throw new NumberOfParamsException();
                case "Wire":
                    if(params.size() == 5)
                        return new Wire(
                                Integer.parseInt(params.get(1)),
                                Integer.parseInt(params.get(2)),
                                Integer.parseInt(params.get(3)),
                                Integer.parseInt(params.get(4))
                        );
                    else
                        throw new NumberOfParamsException();
                default:
                    return null;
            }
        }catch(NumberFormatException e){
            throw new ParametersFormatException();
        }
    }

}
