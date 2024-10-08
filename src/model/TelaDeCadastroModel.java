package controller;
import model.*;
import view.*;


public class TelaDeCadastroController extends TelaDeCadastroView {
    public String[] retornoUsuario =  { 
        "Email já cadastrado! Favor digitar outro email e tentar novamente.", // resposta 0
        // boolean = declaração de um metodo que vai retornar verdadeiro ou falso
        "Não foi possível realizar o seu cadastro, por uma falha no servidor! Por favor, tente novamente mais tarde. , " // resposta 1
        "Cadastro realizado com sucesso" // resposta 2
    };
}

try {
    Connection conexao = MySQLConnector.conectar();
    String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + email + "';";
    Statement stmSqlEmail = conexao.createStatement();
    ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);     
    if(rstSqlEmail.next()) {
        return false;
        // lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente."));
    
    } else {
        lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro."));
        String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + nome + "', '" + email + "', '" + senha + "');";
        // System.out.println(strSqlCadastrar);

        Statement stmSqlCadastrar = conexao.createStatement();
        stmSqlCadastrar.addBatch(strSqlCadastrar);
        stmSqlCadastrar.executeBatch();
        lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso"));
} 
stmSqlEmail.close();
} catch (Exception e) {
    lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
    System.err.println("Erro: " + e);
}

}

}