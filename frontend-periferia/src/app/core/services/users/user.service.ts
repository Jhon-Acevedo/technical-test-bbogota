import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {IApiResponseUser} from "../../models/IApiResponseUser";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  urlApi = 'http://localhost:8090/users/'


  constructor(private http: HttpClient) {
  }

  getUser(typeDocument: String, documentNumber: number): Observable<any> {
    const params = new HttpParams()
      .set('typeDocument', typeDocument.toString())
      .set('documentNumber', documentNumber)
    return this.http.get<IApiResponseUser>(this.urlApi, {params: params})
  }

}
