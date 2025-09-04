package huydv.jmaster.ClientRegisterService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "oauth2_registered_client")
@Data
public class Client {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "client_id", length = 255)
    private String clientId;

    @Column(name = "clientIdIssuedAt")
    private String clientIdIssuedAt;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "client_secret_expires_at")
    private String clientSecretExpiresAt;

    @Column(name = "client_name")
    private String clientName;

    @Column(length = 1000, name = "client_authentication_methods")
    private String clientAuthenticationMethods;

    @Column(length = 1000, name = "authorization_grant_types")
    private String authorizationGrantTypes;


    @Column(length = 1000, name = "redirect_uris")
    private String redirectUris;


    @Column(length = 1000, name = "post_logout_redirect_uris")
    private String postLogoutRedirectUris;


    @Column(length = 1000, name = "scopes")
    private String scopes;


    @Column(length = 2000, name = "client_settings")
    private String clientSettings;

    @Column(length = 2000, name = "token_settings")
    private String tokenSettings;


}
