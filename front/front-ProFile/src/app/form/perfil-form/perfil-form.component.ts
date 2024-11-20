import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { take } from 'rxjs';

@Component({
  selector: 'app-perfil-form',
  templateUrl: './perfil-form.component.html',
  styleUrls: ['./perfil-form.component.css']
})
export class PerfilFormComponent implements OnInit {
  forms!: FormGroup

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly http: HttpClient) {

  }

  ngOnInit(): void {
    this.forms = this.formBuilder.group({
      nome: [null],
      sobrenome: [null],
      email: [null],
      senha: [null],
      referencia: [null],
    })
  }

  showPassword = true;

  getInputType() {
    if (this.showPassword) {
      return 'text';
    }
    return 'password';
  }

  toggleShowPassword() {
    this.showPassword = !this.showPassword;
  }

  onSubmit() {
    console.log(this.forms);

    this.http.get('http://localhost:8080/v1/get/all/perfis').subscribe(resp => {
      console.log(resp)
    })


  }

}
