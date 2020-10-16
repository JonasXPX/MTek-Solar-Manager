package br.uniamerica.mtecksolar.MTeck.Solar.config.security;

public class SecurityConstraints {
  public static final long EXPIRATION_TIME = 864_000_000;
  public static final String SECRET = "jonas";
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/user/**";
}
