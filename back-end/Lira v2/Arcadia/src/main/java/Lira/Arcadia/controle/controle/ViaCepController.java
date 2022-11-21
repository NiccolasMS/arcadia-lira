//package Lira.Arcadia.controle.controle;
//
//import com.gtbr.ViaCepClient;
//import com.gtbr.domain.Cep;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/via-cep")
//public class ViaCepController {
//
//    Cep cep;
//
//    public boolean cepValido(String cep)
//    {
//        if(cep.length() == 8)
//        {
//            return  true;
//        }
//
//            return  false;
//    }
//
//    @GetMapping("/Cep")
//    public ResponseEntity getCep(String cepDoCliente)
//    {
//        if(!cepValido(cepDoCliente))
//        {
//            return  ResponseEntity.status(404).build();
//        }
//
//        cep = ViaCepClient.findCep(cepDoCliente);
//
//        return ResponseEntity.status(200).body(cep);
//    }
//
//
//    @GetMapping("/logradouro")
//    public ResponseEntity getLogradouro(String cepDoCliente)
//    {
//        if(!cepValido(cepDoCliente))
//        {
//            return  ResponseEntity.status(404).build();
//        }
//
//        cep = ViaCepClient.findCep(cepDoCliente);
//
//       return ResponseEntity.status(200).body(cep.getLogradouro());
//    }
//
//    @GetMapping("/complemento")
//    public ResponseEntity getComplemento(String cepDoCliente)
//    {
//        if(!cepValido(cepDoCliente))
//        {
//            return  ResponseEntity.status(404).build();
//        }
//
//        cep = ViaCepClient.findCep(cepDoCliente);
//
//        return ResponseEntity.status(200).body(cep.getComplemento());
//    }
//
//    @GetMapping("/bairro")
//    public ResponseEntity getBairro(String cepDoCliente)
//    {
//        if(!cepValido(cepDoCliente))
//        {
//            return  ResponseEntity.status(404).build();
//        }
//
//        cep = ViaCepClient.findCep(cepDoCliente);
//
//        return ResponseEntity.status(200).body(cep.getBairro());
//    }
//
//    @GetMapping("/localidade")
//    public ResponseEntity getLocalidade(String cepDoCliente)
//    {
//        if(!cepValido(cepDoCliente))
//        {
//            return  ResponseEntity.status(404).build();
//        }
//
//        cep = ViaCepClient.findCep(cepDoCliente);
//
//        return ResponseEntity.status(200).body(cep.getLocalidade());
//    }
//
//    @GetMapping("/uf")
//    public ResponseEntity getUf(String cepDoCliente)
//    {
//
//        if(!cepValido(cepDoCliente))
//        {
//            return  ResponseEntity.status(404).build();
//        }
//
//        cep = ViaCepClient.findCep(cepDoCliente);
//
//        return ResponseEntity.status(200).body(cep.getUf());
//    }
//
//
//}
