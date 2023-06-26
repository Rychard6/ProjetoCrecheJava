package com.tropa.test;

import com.tropa.entities.Mensalidade;
import com.tropa.models.MensalidadeModel;
import java.util.List;

public class MensalidadeTest {
    public static void main(String[] args) {
        MensalidadeModel mensalidadeModel = new MensalidadeModel();
        
        // Test create()
        Mensalidade m = new Mensalidade();
        m.setDataPagamento("10/10/2010");
        m.setDataVencimento("10/10/2010");
        m.setPaga(1);
        m.setValor(550.0);
        
        boolean createResult = mensalidadeModel.create(m);
        System.out.println("Criado?: " + createResult);
        System.out.println();
        
        // Test findAll()
        List<Mensalidade> mensalidades = mensalidadeModel.findAll();
        System.out.println();
        System.out.println("Mensalidades:");
        for (Mensalidade mensalidade : mensalidades) {
            System.out.println(mensalidade);
        }
        System.out.println();
        
        // Test find()
        int mensalidadeId = 1; 
        Mensalidade foundMensalidade = mensalidadeModel.find(mensalidadeId);
        if (foundMensalidade != null) {
            System.out.println("Mensalidade encontrada:");
            System.out.println(foundMensalidade);
            System.out.println();
        } else {
            System.out.println("Mensalidade nao encontrada.");
        }
        
        // Test update()
        int updateMensalidadeId = 1;
        Mensalidade updateMensalidade = mensalidadeModel.find(updateMensalidadeId);
        if (updateMensalidade != null) {
            updateMensalidade.setValor(150.0);
            updateMensalidade.setPaga(1);
            
            boolean updateResult = mensalidadeModel.update(updateMensalidade);
            System.out.println("Update Result: " + updateResult);
            System.out.println();
        } else {
            System.out.println("Mensalidade nao encontrada");
        }
        
        // Test delete()
        int deleteMensalidadeId = 1; 
        Mensalidade deleteMensalidade = mensalidadeModel.find(deleteMensalidadeId);
        if (deleteMensalidade != null) {
            boolean deleteResult = mensalidadeModel.delete(deleteMensalidade);
            System.out.println("Delete Result: " + deleteResult);
            System.out.println();
        } else {
            System.out.println("Mensalidade nao encontrada");
        }
    }
}
