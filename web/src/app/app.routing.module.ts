import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './shared/guard/auth.guard';
import { PaginaNaoEncontradaComponent } from './shared/template/pagina-nao-encontrada.component';


const appRoutes: Routes = [
  {
    path: 'home',
    loadChildren: () => import(`./home/home.module`).then(m => m.HomeModule),
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    canLoad: [AuthGuard]
  },
  {
    path: 'exemplo',
    loadChildren: () => import(`./exemplo/exemplo.module`).then(m => m.ExemploModule),
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    canLoad: [AuthGuard]
  },

  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: '**', component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, { useHash: true })],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
