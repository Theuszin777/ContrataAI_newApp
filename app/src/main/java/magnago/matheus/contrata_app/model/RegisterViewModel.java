package magnago.matheus.contrata_app.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterViewModel extends AndroidViewModel {
    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> register(String newNome, String newEmail, String newCpf, String newPassword, String newProfissao) {

        MutableLiveData<Boolean> result = new MutableLiveData<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                ConecBD conecBD = new ConecBD(getApplication());

                boolean b = conecBD.register(newNome, newEmail, newCpf, newPassword, newProfissao);
                result.postValue(b);
            }
        });
        return result;
    }

}
