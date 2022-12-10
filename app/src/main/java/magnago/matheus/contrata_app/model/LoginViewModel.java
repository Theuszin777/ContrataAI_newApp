package magnago.matheus.contrata_app.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginViewModel extends AndroidViewModel {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> login(String email, String password) {

        MutableLiveData<Boolean> result = new MutableLiveData<>();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {


            @Override
            public void run() {

                ConecBD conecBD = new ConecBD(getApplication());

                boolean b = conecBD.login(email, password);

                result.postValue(b);
            }
        });

        return result;
    }

}
