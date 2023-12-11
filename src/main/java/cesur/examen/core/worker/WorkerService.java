package cesur.examen.core.worker;

import java.util.Date;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Daniel Eastwell
 * Fecha:
 *
 *  No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 *  En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 *  o para seguir la traza de ejecución.
 */
/**
 *  Services classes offers methods to our main application, and can
 *  use multiple methods from DAOs and Entities.
 *  It's a layer between Data Access Layer and Aplication Layer (where
 *  Main app and controllers lives)
 *  It helps to encapsulate multiple opperations with DAOs that can be
 *  reused in application layer.
 */
public class WorkerService {
    /*
    RenovateWorker() set "from" date of the worker with this dni to today's date.
    Remember Date().
    Returns the new updated worker, null if fails or dni doesn't exist.
    */
    private static final WorkerDAO workerDAO = new WorkerDAO();
    public static Worker renovateWorker(String dni){
        Worker workerUpdate = workerDAO.getWorkerByDNI(dni);

        if(workerUpdate != null){

            Date currentDate = new Date(System.currentTimeMillis());

            workerUpdate.setFrom(currentDate);

            Worker updatedWorker = workerDAO.update(workerUpdate);

            if (updatedWorker != null) {
                return updatedWorker;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
