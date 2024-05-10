import {Component} from '@angular/core';
import {UserService} from "../../core/services/users/user.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {catchError, of} from "rxjs";
import {SeparatorDirective} from "../../separator.directive";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HttpClientModule, FormsModule, SeparatorDirective],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  typeDocument: string = '';
  documentNumber!: number;

  constructor(
    private userService: UserService,
    private router: Router,
    private toastService: ToastrService
  ) {
  }

  // 23445322

  onSubmit() {
    if (!this.typeDocument || !this.documentNumber) {
      this.toastService.error('Debe completar todos los campos', 'Error', {});
      return;
    }

    this.documentNumber = this.documentNumber = parseInt(this.documentNumber.toString().replace(/,/g, ''));

    if (this.documentNumber.toString().length < 8 || this.documentNumber.toString().length > 11) {
      this.toastService.info('El documento debe tener entre 8 y 11 caracteres', 'Numero de documento', {});
      return;
    }

    this.userService.getUser('C', this.documentNumber)
      .pipe(
        catchError((error) => {
            if (error.status === 404)
              this.toastService.info('El usuario ' + this.documentNumber + ' no existe', 'Userio no encontrado', {});
            return of(error);
          }
        )
      ).subscribe({
      next: (res) => {
        if (res.status !== 404) {
          this.toastService.success('Usuario encontrado', 'Exito', {});
          localStorage.setItem('user', JSON.stringify(res));
          this.router.navigate(['/user-details']).then(r => (r));
        }
      },
      error: (e) => {
        console.error(e);
        this.toastService.error('Error ' + e.toString(), 'Error', {});
      }
    });
  }

}
