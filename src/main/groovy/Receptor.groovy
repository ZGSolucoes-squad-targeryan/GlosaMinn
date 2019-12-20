import com.google.gson.Gson
import groovy.transform.CompileStatic

@CompileStatic
class Receptor {

    static DtoArquivoConvenio[] getJsonConvenio(String jsonConvenio) {
        return new Gson().fromJson(jsonConvenio, DtoArquivoConvenio[].class);
    }

    static DtoArquivoConvenio[] getJsonHospital(String jsonConvenio) {
        return new Gson().fromJson(jsonConvenio, DtoArquivoConvenio[].class);
    }

}
