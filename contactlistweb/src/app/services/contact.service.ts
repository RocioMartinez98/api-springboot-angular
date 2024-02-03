import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contact } from '../model/contact.interface';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Contact[]>("http://localhost:8080/api/contacts");
  }

  get(id: number) {
    return this.http.get<Contact>(`http://localhost:8080/api/contacts/${id}`);
  }

  create(contact: Contact) {
    console.log("Datos recibidos en el servicio:", contact);
    return this.http.post<Contact>("http://localhost:8080/api/contacts", contact);
  }

  update(id: number, contact: Contact) {
    return this.http.put<Contact>(`http://localhost:8080/api/contacts/${id}`, contact);
  }

  delete(id: number) {
    return this.http.delete<void>(`http://localhost:8080/api/contacts/${id}`);
  }

}
