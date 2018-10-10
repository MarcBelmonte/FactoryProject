package edu.upc.eetac.dsa;

import java.util.HashMap;

public class Factory{

    private static final String PACKAGE = "edu.upc.eetac.dsa";
    private static Factory instance;
    private HashMap<String, Command> cache = new HashMap<String, Command>();


    private Factory(){
    }

    public static Factory getInstance() {
        if(instance == null) instance = new Factory();
        return instance;
    }
    public  Command getCommand(String idCommand){
        Command c = cache.get(idCommand);
        if (c==null){
            c = getCommand2(idCommand);
            cache.put(idCommand,c);
        }else System.out.println("Hola");

        return c;
    }
    private Command getCommand2(String idCommand){
        Command command = null;
        Class c = null;
        try{
            c = Class.forName(PACKAGE+"."+idCommand);
            command = (Command)c.newInstance();

        } catch (Exception e){
            e.printStackTrace();
        }
        return command;
    }
}
