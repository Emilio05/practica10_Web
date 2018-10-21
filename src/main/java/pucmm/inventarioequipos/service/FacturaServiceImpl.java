package pucmm.inventarioequipos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucmm.inventarioequipos.model.Factura;
import pucmm.inventarioequipos.repository.FacturaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service("facturaService")
@Transactional

public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public void crearFactura(Factura factura){
        facturaRepository.save(factura);
    }
    public void actualizarFactura(Factura factura){
        crearFactura(factura);
    }
    public void borrarFacturaPorId(long id){
        facturaRepository.delete(id);
    }
    public void borrarTodasLasFacturas(){
        facturaRepository.deleteAll();
    }
    public List<Factura> buscarTodasFacturas(){
        return facturaRepository.findAll();
    }
    @Override
    public Factura buscarPorId(long id){
        return facturaRepository.findOne(id);
    }
    public boolean facturaExiste(Factura factura){
        return buscarPorId(factura.getId()) != null;
    }
}
