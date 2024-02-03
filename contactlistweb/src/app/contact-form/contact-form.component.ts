import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})

export default class ContactFormComponent {
  private fb = inject(FormBuilder);
  private contactService = inject(ContactService);
  private router = inject(Router);

  form = this.fb.group({
    name: ["" , [Validators.required]],
    email: ["", [Validators.required]],
  });

  create(){
    const contact = this.form.value;
    console.log(this.form.value);
    this.contactService.create(contact)
    .subscribe(() => {
      this.router.navigate(["/"]);
    });
  }
}
