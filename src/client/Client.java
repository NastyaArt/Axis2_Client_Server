package client;

import server.MySQLServiceEquipment;
import models.*;

import java.util.List;
import java.util.ArrayList;

public class Client {

    private MySQLServiceEquipment client;

    public void connect(){
        client = new MySQLServiceEquipment();
        System.out.println("Connection open");
    }

    public List<Equipment> getEquipment()
    {
        List<Equipment> list = new ArrayList<Equipment>();
        try{
            list = client.getEquipment();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return list;
    }

    public List<Cabinet> getCabinet()
    {
        List<Cabinet> list = new ArrayList<Cabinet>();
        try{
            list = client.getCabinet();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return list;
    }

    public List<Responsible> getResponsible()
    {
        List<Responsible> list = new ArrayList<Responsible>();
        try{
            list = client.getResponsible();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return list;
    }

    public List<Distribution> getDistribution()
    {
        List<Distribution> list = new ArrayList<Distribution>();
        try{
            list = client.getDistribution();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return list;
    }

    public List<Writeoff> getWriteoff()
    {
        List<Writeoff> list = new ArrayList<Writeoff>();
        try{
            list = client.getWriteoff();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return list;
    }

    public void addEquipment(Equipment eq)
    {
        try{
            client.addEquipment(eq);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void addCabinet(Cabinet cab)
    {
        try{
            client.addCabinet(cab);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void addResponsible(Responsible resp)
    {
        try{
            client.addResponsible(resp);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void addDistribution(Distribution dist)
    {
        try{
            client.addDistribution(dist);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void addWriteoff(Writeoff wr)
    {
        try{
            client.addWriteoff(wr);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void delEquipment(int code)
    {
        try{
            client.delEquipment(code);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void delCabinet(int code)
    {
        try{
            client.delCabinet(code);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void delResponsible(int code)
    {
        try{
            client.delResponsible(code);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void delDistribution(int code)
    {
        try{
            client.delDistribution(code);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void delWriteoff(int code)
    {
        try{
            client.delWriteoff(code);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void editEquipment(Equipment eq)
    {
        try{
            client.editEquipment(eq);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void editCabinet(Cabinet cab)
    {
        try{
            client.editCabinet(cab);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void editResponsible(Responsible resp)
    {
        try{
            client.editResponsible(resp);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void editDistribution(Distribution dist)
    {
        try{
            client.editDistribution(dist);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void editWriteoff(Writeoff wr)
    {
        try{
            client.editWriteoff(wr);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void close(){
        System.out.println("Connection closed");
    }
}


