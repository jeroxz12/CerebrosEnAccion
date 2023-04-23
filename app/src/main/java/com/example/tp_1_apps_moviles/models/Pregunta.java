package com.example.tp_1_apps_moviles.models;

public class Pregunta {

    private String pregunta;
    private String [] respuestas;
    private Integer indiceRespuestaCorrecta;

    public Pregunta() {
    }

    public Pregunta(String pregunta, String[] respuestas, Integer indiceRespuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.indiceRespuestaCorrecta = indiceRespuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public Integer getIndiceRespuestaCorrecta() {
        return indiceRespuestaCorrecta;
    }

    public void setIndiceRespuestaCorrecta(Integer indiceRespuestaCorrecta) {
        this.indiceRespuestaCorrecta = indiceRespuestaCorrecta;
    }
}
