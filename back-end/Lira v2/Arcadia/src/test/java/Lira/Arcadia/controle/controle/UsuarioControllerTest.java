package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Porteiro;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import Lira.Arcadia.controle.repositorio.MoradorRepository;
import Lira.Arcadia.controle.repositorio.PorteiroRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    UsuarioController controller;

    @MockBean
    MoradorRepository moradorRepository;
    @MockBean
    PorteiroRepository porteiroRepository;

    @MockBean
    EncomendaRepository encomendaRepository;

    @Test
    @DisplayName("postPorteiro deve retornar status 400 e mensagem informativa")
    void postSemNome()
    {
        Porteiro porteiro = new Porteiro("porteiro@hotmail.com","123","","(11) 94377-1393",1);
        Porteiro porteiro2 = new Porteiro("porteiro2@hotmail.com","123",null,"(11) 94377-1393",2);

        assertEquals(400, controller.postPorteiro(porteiro).getStatusCodeValue());
        assertEquals(400,controller.postPorteiro(porteiro2).getStatusCodeValue());
    }

    @Test
    @DisplayName("postPorteiro deve retornar status 400 se o nome tiver menos de 3 caracteres")
    void PostNomeCaracteres()
    {
        Porteiro porteiro = new Porteiro("porteiro@hotmail.com","123","AA","(11) 94377-1393",1);

        assertEquals(400,controller.postPorteiro(porteiro).getStatusCodeValue());
    }

    @Test
    @DisplayName("postPorteiro deve retornar status 201")
    void PostPorteiro201()
    {
        Porteiro porteiro = new Porteiro("porteiro@hotmail.com","123","Fernando","(11) 94377-1393",1);

        assertEquals(201,controller.postPorteiro(porteiro).getStatusCodeValue());
    }

    @Test
    @DisplayName("postPorteiro deve validar o domínio do email")
    void PostPorteiroEmail()
    {
        Porteiro porteiro = new Porteiro("porteiro@a.com","123","Fernando","(11) 94377-1393",1);

        assertEquals(400, controller.postPorteiro(porteiro).getStatusCodeValue());
    }

    @Test
    @DisplayName("postPorteiro deve validar o telefone")
    void PostPorteiroTelefone()
    {
        Porteiro porteiro = new Porteiro("porteiro@hotmail.com","123","Fernando",
                "94377-1393",1);

        assertEquals(400,controller.postPorteiro(porteiro).getStatusCodeValue());
    }

    @Test
    @DisplayName("postPorteiro deve retornar status 400 se a senha tiver menos de 3 caracteres")
    void PostSenhaCaracteres()
    {
        Porteiro porteiro = new Porteiro("porteiro@hotmail.com","12","AAA","(11) 94377-1393",1);

        assertEquals(400,controller.postPorteiro(porteiro).getStatusCodeValue());
    }

    @Test
    @DisplayName("Condominio do porteiro não deve ser null")
    void PostPorteiroCondominio()
    {
        Porteiro porteiro = new Porteiro("porteiro@hotmail.com","123","AAA","(11) 94377-1393",1);

        assertEquals(400,controller.postPorteiro(porteiro).getStatusCodeValue());
    }
}